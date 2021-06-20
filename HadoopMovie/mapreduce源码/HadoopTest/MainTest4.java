package HadoopTest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainTest4 {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
	    job.setMapperClass(Mapper4.class);
	    job.setReducerClass(Reducer4.class);
	    FileInputFormat.setInputPaths(job,new Path("./input"));
	    FileOutputFormat.setOutputPath(job, new Path("./out4"));
	    job.setMapOutputKeyClass(Text.class);
	    //job.setReducerOutputClass(NullWritable.class);
	    job.setMapOutputValueClass(IntWritable.class);
	    job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.waitForCompletion(true);
	}
}
