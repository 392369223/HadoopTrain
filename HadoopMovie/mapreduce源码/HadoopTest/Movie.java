package HadoopTest;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class Movie implements Writable{
	private String film;
	private int num;
	public Movie() {
		super();
	}
	public Movie(String film, int num) {
		super();
		this.film = film;
		this.num = num;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return film+"\t"+num+"\t";
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		film=arg0.readUTF();
		num=arg0.readInt();
	}
	@Override
	public void write(DataOutput arg0) throws IOException {
		arg0.writeUTF(film);
		arg0.writeInt(num);
	}	
}
