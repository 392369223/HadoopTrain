package HadoopTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer2 extends Reducer<Text,Character1,Text,Character1>{
	ArrayList<Character1> arr=new ArrayList<Character1>();
	@Override
	protected void reduce(Text arg0, Iterable<Character1> arg1,
			Reducer<Text, Character1, Text, Character1>.Context arg2) throws IOException, InterruptedException {
		Iterator<Character1> iterator = arg1.iterator();
		while(iterator.hasNext()){
			Character1 next = iterator.next();
			arr.add(new Character1(next.getMovieName(),next.getScore()));
		}
		arr.sort(new Comparator<Character1>() {
           	@Override
			public int compare(Character1 o1, Character1 o2) {
				if(o1.getScore()>o2.getScore()){
					return -1;
				}else if(o1.getScore()==o2.getScore()){
					return 0;
				}else{
					return 1;
				}
			}
		});
		arg2.write(arg0,arr.get(0));
		arr.clear();
	}
}
