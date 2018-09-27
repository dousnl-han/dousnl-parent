package com.dousnl.hadoop;
/*package com.dousnl.hadoop;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HadoopReduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>{

	@Override
	public void reduce(Text key, Iterator<Text> values, 
			OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
         long count=0;//计算总数
         while (values.hasNext()) {
        	 String valuetemp=values.next().toString();
        	 long temp=Long.parseLong(valuetemp);
        	 count+=temp;
		}
         output.collect(key, new Text(count+""));
	}

}
*/