package HadoopTest;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Character1 implements Writable{
	private String movieName;
	private double score;
	public Character1() {
		super();
	}
	public Character1(String movieName, double score) {
		super();
		this.movieName = movieName;
		this.score = score;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return  movieName + "\t"+ score + "\t";
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
	movieName=arg0.readUTF();
	score=arg0.readDouble();
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		arg0.writeUTF(movieName);
		arg0.writeDouble(score);
	}
}
