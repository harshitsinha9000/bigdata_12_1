import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Mapper121 extends Mapper<LongWritable, Text,Text,IntWritable> {
	public void map(LongWritable key, Text value,Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("|");
		String NA = new String("NA");
		Text txt;
		
		
		if(!((lineArray[0].equalsIgnoreCase(NA))||(lineArray[1].equalsIgnoreCase(NA))))
		{
			context.write(new Text(lineArray[0]),new IntWritable(1));
			
		}
		
	}

}
