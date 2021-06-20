package HadoopTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer5 extends Reducer<Text,IntWritable,Text,IntWritable>{
	public HashMap<String,Integer> map=new HashMap<String,Integer>();
	@Override
	protected void reduce(Text arg0, Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		//lst.add(Map.Entry<String,Integer>(arg0.toString(),getSum(arg1)));
		map.put(arg0.toString(), getSum(arg1));
	}
	public static int getSum(Iterable<IntWritable> t){
		int sum=0;
		Iterator<IntWritable> it = t.iterator();
		while(it.hasNext()){
			sum=sum+it.next().get();
		}
		return sum;
	}
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		ArrayList<Entry<String, Integer>> arr= new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		arr.sort(new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()>o2.getValue()){
					return -1;		
				}else if(o1.getValue()==o2.getValue()){
					return 0;
				}else{
					return 1;
				}
			}
		});
		int count=0;
		while(arr.size()>2&&count<2){
			//System.out.println(arr.get(count).getKey()+"---"+arr.get(count).getValue());
		    context.write(new Text(arr.get(count).getKey()),new IntWritable(arr.get(count).getValue()));
		    count++;
		}
	}
	
}
