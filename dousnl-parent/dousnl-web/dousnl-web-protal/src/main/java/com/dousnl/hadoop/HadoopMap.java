package com.dousnl.hadoop;
/*package com.dousnl.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HadoopMap extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>{

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text,Text> output, Reporter repoter) throws IOException {

		String [] input_fileds=value.toString().split(" ");
		output.collect(new Text(input_fileds[3]), new Text("1"));
	}

}
*/