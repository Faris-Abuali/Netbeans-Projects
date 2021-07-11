
import java.io.IOException;
import org.apache.commons.text.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.util.GenericOptionsParser;


/**
 *
 * @author Fares Abuali
 */
public class SalesCountryExample2 {
    
    /* Second Example: 
    Based on the same data set, return for each country the sold product with quantity*/
    
    public static void main(String[] args) throws Exception{
        
 
        
        Configuration conf = new Configuration();
        //Job job = Job.getInstance(conf, "word count");
        Job job = new Job(conf, "word count");
        job.setJarByClass(WordCountDriver.class);
        
      
        
        job.setMapperClass(TokenizerMapper.class); // extends Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        job.setCombinerClass(IntSumReducer.class); // extends Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        job.setReducerClass(IntSumReducer.class); // extends Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
       
        
      //Now Set the datatype of the final output key-value pairs
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
          
                
        
        FileInputFormat.addInputPath(job, new Path("input.txt"));
        FileOutputFormat.setOutputPath(job, new Path("output.txt"));

//        FileInputFormat.addInputPath(job, new Path("input_file.txt"));
//        FileOutputFormat.setOutputPath(job, new Path("output.txt"));
        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        
        
    }// end main
    
    
 //====================================================================================================   
    public static class TokenizerMapper
            extends Mapper<LongWritable, Text, Text[], IntWritable>{ //Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        // KEYIN: is the line offset
        // VALUEIN: is the content of this line
               
        private final static IntWritable one = new IntWritable(1);
        //private Iterable<Text> word = null;
        
        private Text[] arr = new Text[2];  // [productName, countryName]
            
        //mapper input: map(longWritable, Text) => lineOffset, contentOftheLine
        //mapper output: Each map() invokation produces a List of (Text, 1) 
      
        @Override
        public void map(LongWritable key, Text value, Context context) // input for map is: key = LongWritable, value = Text
            throws IOException, InterruptedException{


                String[] lineContentArray = value.toString().split(",");

                arr[0] = new Text(lineContentArray[1]); //product name
                arr[1] = new Text(lineContentArray[4]); // country
                
                context.write(arr, one);    //Ex: ([USA,Product1], 1),  ([USA,Product2], 1), ([UK,Product1], 1)
        }// end method map
        
    }// end TokenizerMapper Class
    
    
 //====================================================================================================   
    public static class IntSumReducer
            extends Reducer<Text[], IntWritable, Text[], IntWritable>{
        
        
    /*
      • Mapper output key = Text —> Reducer input key = Text
      • Mapper output value = IntWritable —> Reducer input value = IntWritable
    */
        private IntWritable result = new IntWritable();
        
        @Override
        public void reduce(Text[] key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException{ 
            // input for reduce is: key = Text, value = List of IntWritable
            
            int sum = 0;
            
            for(IntWritable val: values){
                
                sum += val.get();
            }
            
            result.set(sum);
            context.write(key, result); // Ex ([USA,product1), 2), ([USA, product2], 1)
            
        }// end method reduce
        
    }// end IntSumReducer Class
    
    
    
}// end class
