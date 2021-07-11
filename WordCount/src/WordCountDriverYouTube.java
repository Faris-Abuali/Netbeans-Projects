
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


/**
 *
 * @author Fares Abu Ali
 */
public class WordCountDriverYouTube {
    
    
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        
        
        Configuration config = new Configuration();
        
        String[] files = new GenericOptionsParser(config, args).getRemainingArgs();
        Path input = new Path(files[0]); //input file
        Path output = new Path(files[1]); //output file
        
        
        Job job = new Job(config, "WordCount");
        
        job.setJarByClass(WordCountDriverYouTube.class);
        job.setMapperClass(WordCountMapperYouTube.class); // extends Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        job.setCombinerClass(WordCountReducerYouTube.class); // extends Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        job.setReducerClass(WordCountReducerYouTube.class); // extends Reducer<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
        
        //Now Set the datatype of the final output key-value pairs
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        FileInputFormat.addInputPath(job, input);
        FileOutputFormat.setOutputPath(job, output);
        
       System.exit(job.waitForCompletion(true) ? 0 : 1);

    }// end main
    
}// end class
