
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fares Abu Ali
 */
 public class WordCountReducerYouTube
            extends Reducer<Text, IntWritable, Text, IntWritable>{
        
        
    /*
      • Mapper output key = Text —> Reducer input key = Text
      • Mapper output value = IntWritable —> Reducer input value = IntWritable
    */
        private IntWritable result = new IntWritable();
        
       
        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException{ 
            // input for reduce is: key = Text, value = List of IntWritable
            
            int sum = 0;
            
            for(IntWritable val: values){
                
                sum += val.get();
            }
            
            result.set(sum);
            context.write(key, result);
            
        }// end method reduce
        
 }// end WordCountReducerYouTube Class
