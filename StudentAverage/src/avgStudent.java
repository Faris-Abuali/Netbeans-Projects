
import java.io.IOException;
import org.apache.commons.text.StringTokenizer;
import org.apache.curator.shaded.com.google.common.collect.Iterables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
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
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author hp
 */
public class avgStudent {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "studant avg grade");

        job.setJarByClass(avgStudent.class);

        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(avgStudentReducer.class);
        job.setReducerClass(avgStudentReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(DoubleWritable.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }// end main

    //Mapper
    static class TokenizerMapper extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {

        private static DoubleWritable grade = new DoubleWritable();
        private IntWritable id = new IntWritable();

        @Override
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            StringTokenizer line = new StringTokenizer(value.toString(), ',');

            while (line.hasNext()) {

                String id_string = line.nextToken(); // student_id
                
                line.nextToken(); // course_name
                
                String grade_string = line.nextToken(); // student_grade
                             
                id.set(Integer.parseInt(id_string));
                grade.set(Double.parseDouble(grade_string));

            }
        }
        
    } 
//=======================================================================================================   
    public static class avgStudentReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

        private DoubleWritable avg = new DoubleWritable();

        @Override
        public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            int i = 0;
            for (DoubleWritable val : values) {
                sum += val.get();
                i++;
            }
            avg.set((double) sum / i);
            context.write(key, avg);
        }
    }
    
}

