import java.io.IOException;

import javax.security.auth.login.Configuration;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Counters;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.v2.api.records.CounterGroup;

public class Counterclass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub

		Configuration conf = Configuration.getConfiguration();
		Job job = Job.getInstance();
		job.setJarByClass(Counterclass.class);
		
		job.setMapperClass(Mapper121.class);
		job.setNumReduceTasks(0);
		 
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0])); 
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		
	    job.setJobID(job.getJobID());
		
		job.waitForCompletion(true);
		
		
		Counters cn = job.getCounters();
		
		for (org.apache.hadoop.mapreduce.CounterGroup group : cn) 
		{
				 
		System.out.println("* Counter Group: " + group.getDisplayName() + " (" + group.getName() + ")");
				 
		System.out.println(" number of counters in this group: " + group.size());
				 
		
		for (Counter counter : group) 
		{
				 
		System.out.println(" - " + counter.getDisplayName() + ": " + counter.getName() + ": "+counter.getValue());
		
		}
		
		
		
		
		
	}

}
}
