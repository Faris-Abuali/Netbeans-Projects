
import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author Fares Abu Ali
 */
public class MidTermQ11 {

    public static void main(String[] args)
            throws IOException, InterruptedException, ClassNotFoundException {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Student Average Calculator");
        job.setJarByClass(StudentAverageDriver.class);

        job.setMapperClass(StudentAverageDriver.TokenizerMapper.class);
        //job.setCombinerClass(CalculateAverageReducer.class);
        job.setReducerClass(StudentAverageDriver.CalculateAverageReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(FloatWritable.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);

//        MultipleInputs.add(jobName, path, inputFormatClass, MapperName);
//        
//        MultipleInputs.add
//   
    }// end main

    public static class RSMapper
            extends Mapper<LongWritable, Text, Text, Text> { // KETIN, VALUEIN, KEYOUT, VALUEOUT
        // mapper KEYIN: is the line offset (LongWritable)
        // mapper VALUEIN: is the content of this line (Text)

        // mapper KEYOUT: is the tuple (Text) 
        // mapper VALUEOUT: is the path (Text)
        // I know that "tuple" is a Text contains the content of the line whose offset is the "key"
        @Override
        public void map(LongWritable key, Text tuple, Context context) {

            /*
            • for each tuple t emit a key-value pair
            • key is the tuple itself t
            • value is a tag indicating the dataset containing the tuple; if it is from relation R then value = “R”
            • so key-value is (t,”R”) or (t,”S”)
             */
            // PROJECTION: I need to emit only the: name, id, grade from each tuple
            String[] strArrayTuple = key.toString().split(",");
            //student_name","student_id","student_age","level","grade

            // I need to emit only the: name, id, grade
            String name, id, grade;

            name = strArrayTuple[0].trim(); //student_name
            id = strArrayTuple[1].trim(); //student_id
            grade = strArrayTuple[4].trim(); //student_grade

            String projectedTuple = name + "," + id + "," + grade;

            //emit(projectedTuple, pathOfTheDataset)
            context.write(new Text(projectedTuple), context.getInputSplit().getPath().toString());

        }// end method map

    }// end TokenizerMapper Class

//===========================================================================================
    public static class R_Minus_S_Reducer
            extends Reducer<IntWritable, IntWritable, Text, Text> { // KETIN, VALUEIN, KEYOUT, VALUEOUT

        /*
      • Mapper KEYOUT = IntWritable —> Reducer KEYIN = IntWritable  ***student_id***
      • Mapper VALUEOUT = IntWritable —> Reducer VALUEIN = IntWritable  ***student_grade***
         */
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            /*
             the student who has the lowest grade among students that are only in R (must not be in S)
             */
            /*  /user/cloudera/R/text_files
                /user/cloudera/S/text_files */
 

            String pathR = "", pathS = "";

            boolean tupleExistInR = false, tupleExistInS = false;

            for (Text currentValue : values) {

                if (currentValue.toString().equals(pathR)) {
                    tupleExistInR = true;
                } else if (currentValue.toString().equals(pathS)) {
                    tupleExistInS = true;
                }
            }// end forEatch

            if (tupleExistInR == true && tupleExistInS == false) {
                
            
                context.write(key, key);  // emit(tuple, tuple) remember that the key is the tuple
            }

        }// end mehtod reduce

    }// end R_Minus_S_Reducer

    public static class FindMinimumMapper
            extends Reducer<Text, Text, Text, LongWritable> { // KETIN, VALUEIN, KEYOUT, VALUEOUT


        @Override
        public void map(Text key, Text value, Context context) throws IOException, InterruptedException {

            //now read each line from the dataset and find the minimum grade
            // each line format is: name, id, grade
            String[] arrStr = key.toString().split(",");  // name, id, grade

            int grade = Integer.parseInt(arrStr[2]);

      
            
            
            context.write(key, grades[0])
        }// end mehtod reduce

    }// end CalaculateAverageReducer

    //===========================================================================================
}// end class
