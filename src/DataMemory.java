import java.util.Arrays;

public class DataMemory {

    final static int size = 1024;
    private int[] dataMem;

    public DataMemory(){
        dataMem = new int[size];
        Arrays.fill(dataMem, -1);

    }

    public int write(int idx, int data) {

        dataMem[idx] = data;
        return data;

    }

    public int read(int idx) {

        return dataMem[idx];

    } 
    
	public void fillMem() {
		for(int i = 0; i < size; i++)
			write(i, (int) (Math.random()*1001));
	}

}