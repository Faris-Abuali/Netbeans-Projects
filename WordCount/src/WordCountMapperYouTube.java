
import java.io.IOException;
import org.apache.commons.text.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fares Abu Ali
 */
public class WordCountMapperYouTube 
        extends Mapper<LongWritable, Text, Text, IntWritable>{ //Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
    
        // KEYIN: is the line offset
        // VALUEIN: is the content of this line
        
        
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
        
        
        
        //mapper input: map(longWritable, Text) => lineOffset, contentOftheLine
        //mapper output: Each map() invokation produces a List of (Text, 1) 
    
       @Override
        public void map(LongWritable key, Text value, Context context) // input for map is: key = LongWritable, value = Text
            throws IOException, InterruptedException{
            
            StringTokenizer itr = new StringTokenizer(value.toString());
          
            while(itr.hasNext()){
                word.set(itr.nextToken());
                context.write(word, one);  // write(KEYOUT, VALUEOUT)  KEYOUT = Text & VALUEOUT = IntWritable
            }// end while
             
            /* 
                This is my alternate implementation of the map method:
                String[] lineContentArray = value.toString().split(" ");

                for(String token : lineContentArray){
                    word.set(token);
                    context.write(word, one);
                }
            */
            
        }// end method map
        
        
}// end class
