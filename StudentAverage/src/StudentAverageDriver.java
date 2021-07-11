import java.io.IOException;
import org.apache.commons.text.StringTokenizer;
import org.apache.curator.shaded.com.google.common.collect.Iterables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



/**
 *
 * @author Fares Abu Ali
 */
public class StudentAverageDriver {
    
    public static void main(String[] args) 
            throws IOException, InterruptedException, ClassNotFoundException {
        
  
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Student Average Calculator");
        job.setJarByClass(StudentAverageDriver.class);
        
        job.setMapperClass(TokenizerMapper.class);
      //job.setCombinerClass(CalculateAverageReducer.class);
        job.setReducerClass(CalculateAverageReducer.class);
        
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
    
//================================================================================== =========
    
    
    public static class TokenizerMapper
            extends Mapper<LongWritable, Text, IntWritable, IntWritable>{ // KETIN, VALUEIN, KEYOUT, VALUEOUT
        // mapper KEYIN: is the line offset (LongWritable)
        // mapper VALUEIN: is the content of this line (Text)
        
        // mapper KEYOUT: is the student_id (IntWritable) 
        // mapper VALUEOUT: is the grade (IntWritable)
        
        private static final IntWritable studentID = new IntWritable();
        private static final IntWritable studentGrade = new IntWritable();

        
        @Override
        public void map(LongWritable key, Text value, Context context){
            
            // I know that "value" is a Text contains the content of the line whose offset is the "key"
            
            String[] str_arr = value.toString().split(","); 
            
            String strStudentID = str_arr[0].trim(); //get rid of unnecessary leading spaces
            String strStudentGrade = str_arr[2].trim(); //get rid of unnecessary leading spaces   
            
        /* 
            convert 'value' from Text to String, then split that string into an array considering
            the dilimiter to be a comma (,). 
            This is because I know that data in the input file is "comma separated".
            
            
            Dataset Sample:
            19, web , 85
            19, Database , 90
            20, web, 90
            24, Java , 87
            23, Java, 88
            24, algorithms , 87
            23, algorithms, 88
        */
        
         /* str_arr[0] = student_number
            str_arr[1] = course_name
            str_arr[2] = student_grade  
         */
            
         
            int id = Integer.parseInt(strStudentID); 
            studentID.set(id);
           
            int grade = Integer.parseInt(strStudentGrade);
            studentGrade.set(grade);
            
            try{
               
                context.write(studentID,studentGrade); // write(KEYOUT, VALUEOUT).  KEYOUT = IntWritable & VALUEOUT = IntWritable
            }
            catch(IOException | InterruptedException ex){
                ex.printStackTrace();
            }
            
        }// end method map
 
    }// end TokenizerMapper Class
    
//===========================================================================================
    
    public static class CalculateAverageReducer
            extends Reducer<IntWritable, IntWritable, IntWritable, FloatWritable >{ // KETIN, VALUEIN, KEYOUT, VALUEOUT
  
    /*
      • Mapper KEYOUT = IntWritable —> Reducer KEYIN = IntWritable  ***student_id***
      • Mapper VALUEOUT = IntWritable —> Reducer VALUEIN = IntWritable  ***student_grade***
    */
        
        
        private FloatWritable result = new FloatWritable();
         // result will store the avg. of the grades for the student whose id = key
                     
                     
       @Override
       public void reduce(IntWritable key, Iterable<IntWritable> values, Context context){
           
           // 'key' is an integer (or IntWritable) represents the student_id.
           // 'values' is a list of IntWritable contains the student's grades.
           
           int sum, listSize; 
           /*listSize represents the number of grades for the student 
           (the number of courses for the student. Each course has a grade). */
           
           float avg; // it should be float (not int) (remember 87.5)
           
        /* Some Explanation:
           
           * sum will store the summation of all grades for the student.
           * average = (sum of all grades) / (size of the list) 
          
        */
           sum = listSize = 0; // give them initial values
           avg = 0f; // it should be float (not int)
                   
                   
           
           for(IntWritable grade : values){
               sum += grade.get(); //convert grade to 'int' to add it to the variable 'sum'.
               listSize++;
           }
           
           avg = (float)sum / listSize;
           
           /* I think there is a better way to find the size of Iterable 'values' list:
              I could say:  listSize = Iterables.size(values);
           */
           
             result.set(avg);
           
           try{
                  context.write(key, result); // write(KEYOUT, VALUEOUT).  KEYOUT = IntWritable & VALUEOUT = FloatWritable
           }
           catch(IOException | InterruptedException ex){
                ex.printStackTrace();
           }
            
           
       }// end mehtod reduce
        
        
    }// end CalaculateAverageReducer
    
 //===========================================================================================
            
}// end class
