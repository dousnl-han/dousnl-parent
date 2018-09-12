/*package org.dousnl.hadoop;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class HadoopMain {

	public static void main(String[] args) {

		String win_in="D:/ccc.f";
		String win_out="D:/hadoop.text";
		String input="hdfs://localhost:9000/longlong/temp/access.log";
		String output="hdfs://localhost:9000/longlong/temp/output/";
		JobConf conf=new JobConf(HadoopMain.class);
		conf.setJobName("HadoopMain");
		try {
			//job重跑时候删除之前的输出
			FileSystem fileSystem = new Path(output).getFileSystem(conf);
			fileSystem.delete(new Path(output),true);
			conf.setOutputKeyClass(Text.class);
			conf.setOutputValueClass(Text.class);
			conf.setMapperClass(HadoopMap.class);
			conf.setReducerClass(HadoopReduce.class);
			conf.setInputFormat(TextInputFormat.class);
			conf.setOutputFormat(TextOutputFormat.class);
			FileInputFormat.setInputPaths(conf, new Path(input));
			FileOutputFormat.setOutputPath(conf, new Path(output));
			conf.setNumMapTasks(1);
			conf.setNumReduceTasks(1);
			JobClient.runJob(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
*/