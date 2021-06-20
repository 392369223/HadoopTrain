package HadoopTest;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper5 extends Mapper<LongWritable,Text,Text,IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String s = value.toString();
		String[] split = s.split(",");
		//System.out.println(split.length);
		String[] split2=split[4].split("/");
		for(String s2:split2)
		{
		context.write(new Text(s2), new IntWritable(1));
		}
	}

}
