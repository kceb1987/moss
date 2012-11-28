package moss.modules;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import moss.kernel.MKernel;
import moss.kernel.SchedulerType;
import moss.user.*;
import moss.Time.*;

public class UBatchUnitTests implements MUserProcess{

	public int main (String argv[], MEnv envp){
	int processFailIndicator=0;//Initialize
	int numberOfUnitTests=6;
	int numberOfTestedSchedulers=2;
	String schedulerName="";
	FileWriter write = null;
	PrintWriter print_line;
	try {
		write=new FileWriter("Example_ActualLottery1.rpt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	print_line = new PrintWriter( write );
	print_line.printf("%s"+"%n","Batch Report Example");
	print_line.printf("%s"+"%n","-----------------------------------------");
	
		//Launch batch for FIFO scheduler:
		//MKernel.changeScheduler(SchedulerType.FIFO);
		schedulerName="Lottery Example 1";
			
		MPosixIf.writestring (MPosixIf.STDOUT, "Launching Unit Tests 1-"+numberOfUnitTests+"for "+schedulerName+" scheduler.\n");
		print_line.printf("%s"+"%n","Scheduler::"+schedulerName+"::");
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest1", argv);
		print_line.printf("%s"+"%n","Unit Test 1 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest2", argv);
		print_line.printf("%s"+"%n","Unit Test 2 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest3", argv);
		print_line.printf("%s"+"%n","Unit Test 3 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest4", argv);
		print_line.printf("%s"+"%n","Unit Test 4 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest5", argv);
		print_line.printf("%s"+"%n","Unit Test 5 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest6", argv);
		print_line.printf("%s"+"%n","Unit Test 6 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		
		//Launch Batch For Lottery Scheduler
		MKernel.changeScheduler(SchedulerType.Lottery);
		schedulerName="Lottery Example 2";
		MPosixIf.writestring (MPosixIf.STDOUT, "Launching Unit Tests 1-"+numberOfUnitTests+"for "+schedulerName+" scheduler.\n");
		
		print_line.printf("%s"+"%n","-----------------------------------------");
		print_line.printf("%s"+"%n","Scheduler::"+schedulerName+"::");
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest1", argv);
		print_line.printf("%s"+"%n","Unit Test 1 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest2", argv);
		print_line.printf("%s"+"%n","Unit Test 2 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest3", argv);
		print_line.printf("%s"+"%n","Unit Test 3 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest4", argv);
		print_line.printf("%s"+"%n","Unit Test 4 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest5", argv);
		print_line.printf("%s"+"%n","Unit Test 5 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();
		if(MPosixIf.wait (false)!=null)
		processFailIndicator= MPosixIf.forkexecc ("/bin/unitTest6", argv);
		print_line.printf("%s"+"%n","Unit Test 6 Elapsed Time:"+MProcessTiming.getGlobalTime());
		MProcessTiming.resetGlobalTime();

	
		
	print_line.close();
	//if(MPosixIf.wait (false)!=null){
	if (processFailIndicator < 0) {
		MPosixIf.writestring (MPosixIf.STDOUT, argv[0] + "Failed to complete Unit Test." +"\n");
		MPosixIf.exit (1);
	}
	//}		
	/* now wait for them (this is nicer than just exiting
	 * and letting the init-task scoop them up)
	 */
	for (int x=0; x<1;) {
		int ra[];

		ra = MPosixIf.wait (false);
		if (ra != null) {
			x += (ra.length >> 1);
		}
	}
		MProcessTiming.resetGlobalTime();
		//MPosixIf.exit(0);
		return 0;
	}

	public void signal (int signo, Object sigdata)
	{
		return;
	}
	
}

