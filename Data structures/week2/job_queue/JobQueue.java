import java.io.*;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker, assignedWorkerOld;
    private long[] startTime, startTimeOld;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

	private class WorkerThread implements Comparable<WorkerThread>{
		int id;
		long startTime;
		long freeTime;
		
		WorkerThread(int id, long startTime, long freeTime){
			this.id = id;
			this.startTime = startTime;
			this.freeTime = freeTime;
		}
		
		public int compareTo(WorkerThread w){
			if(freeTime == w.freeTime){
				return id-w.id;
			}else{
				return (int)(freeTime - w.freeTime);
			}
		}
	}
	
    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        
		Queue<WorkerThread> queue = new PriorityQueue<WorkerThread>();
		int i=0;
		while(queue.size()<numWorkers && i<jobs.length){
			assignedWorker[i] = queue.size();
			startTime[i] = 0;
			if(jobs[i] > 0){
				queue.add(new WorkerThread(queue.size(), 0, jobs[i]));
			}
			++i;
		}
		
		for(;i<jobs.length; ++i){
			WorkerThread w = queue.remove();
			w.startTime = w.freeTime;
			w.freeTime += jobs[i];
			assignedWorker[i] = w.id;
			startTime[i] = w.startTime;
			queue.add(w);
		}
    }
	
	private void assignJobsOld(){
		assignedWorkerOld = new int[jobs.length];
        startTimeOld = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
		
		for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            int bestWorker = 0;
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorkerOld[i] = bestWorker;
            startTimeOld[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
	}

    public void solve() throws IOException {
		//stressTest();
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }
	
	private void stressTest(){
		
		for(int a = 1; a<10000; ++a){
			numWorkers = (int)(Math.random()*20) + 1;
			int m = (int)(Math.random()*10);
			jobs = new int[m];
			System.out.println(numWorkers + " " + m);
			for (int i = 0; i < m; ++i) {
				jobs[i] = (int)(Math.random()*500000000);
			}
			printArr(jobs);
			System.out.println();
			assignJobs();
			assignJobsOld();
			if(!checkEqual(assignedWorker, assignedWorkerOld) || !checkEqual(startTimeOld, startTime)){
				printArr(assignedWorker);
				printArr(assignedWorkerOld);
				System.out.println();
				printArr(startTime);
				printArr(startTimeOld);
				System.out.println("FAIL");
				break;
			}else{
				System.out.println("SUCCESS");
			}
			System.out.println();
		}
	}
	
	private boolean checkEqual(long[] arr1, long[] arr2){
		for(int i=0; i<arr1.length; ++i){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
	private boolean checkEqual(int[] arr1, int[] arr2){
		for(int i=0; i<arr1.length; ++i){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
	private void printArr(long[] arr){
		for(long n:arr){
			System.out.print(n);
		}
		System.out.println();
	}
	
	private void printArr(int[] arr){
		for(int n:arr){
			System.out.print(n);
		}
		System.out.println();
	}

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
