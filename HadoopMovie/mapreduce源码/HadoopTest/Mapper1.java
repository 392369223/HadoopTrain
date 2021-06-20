package HadoopTest;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper1 extends Mapper<LongWritable,Text,Text,Movie>{
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Movie>.Context context)
			throws IOException, InterruptedException {
		String s = value.toString();
		String[] split = s.split(",");
		//context.write(new Text());
		context.write(new Text(split[6]), new Movie(split[1],Integer.parseInt(split[5])));
	}
}
