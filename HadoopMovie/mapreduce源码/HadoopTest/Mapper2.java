package HadoopTest;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Mapper2 extends Mapper<LongWritable,Text,Text,Character1>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Character1>.Context context)
			throws IOException, InterruptedException {
	    String s = value.toString();
	    String[] split = s.split(",");
	    context.write(new Text(split[6]), new Character1(split[1],Double.parseDouble(split[2])));
	}
}
