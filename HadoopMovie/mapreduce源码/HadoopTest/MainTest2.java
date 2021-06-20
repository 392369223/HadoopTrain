package HadoopTest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainTest2 {
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
	    job.setMapperClass(Mapper2.class);
	    job.setReducerClass(Reducer2.class);
	    FileInputFormat.setInputPaths(job,new Path("./input"));
	    FileOutputFormat.setOutputPath(job, new Path("./out2"));
	    job.setMapOutputKeyClass(Text.class);
	    //job.setReducerOutputClass(NullWritable.class);
	    job.setMapOutputValueClass(Character1.class);
	    job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Character1.class);
        job.waitForCompletion(true);
	}

}
