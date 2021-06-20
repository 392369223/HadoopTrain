package HadoopTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reducer1 extends Reducer<Text,Movie,Text,Movie>{
	ArrayList<Movie> arr=new ArrayList<Movie>();
	@Override
	protected void reduce(Text arg0, Iterable<Movie> arg1, Reducer<Text, Movie, Text, Movie>.Context arg2)
			throws IOException, InterruptedException {
		Iterator<Movie> iterator = arg1.iterator();
		while(iterator.hasNext()){
			Movie next = iterator.next();
			arr.add(new Movie(next.getFilm(),next.getNum()));
		}
		arr.sort(new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				if(o1.getNum()>o2.getNum()){
				return -1;	
				}else if(o1.getNum()==o2.getNum()){
					return 0;
				}
				else{
					return 1;
				}	
			}
		});
		System.out.println(arr.get(1)+""+arr.get(2));
		int count=0;
		Movie movie=null;
		for (int i=0;i<arr.size();i++) {
			movie=arr.get(i);
			if(count>=2) break;
			else{
				arg2.write(arg0,movie);
				count++;
			}
		}
		arr.clear();
	}
}
