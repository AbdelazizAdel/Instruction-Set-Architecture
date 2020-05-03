public class Cache {

    final static int cacheSize = 512;
    private int[] cache;
    private DataMemory dataMemory;
    private boolean[] valid;
    private int[] tag;

    public Cache() {

        cache = new int[cacheSize];
        dataMemory = new DataMemory();
        dataMemory.fillMem();
        valid = new boolean[cacheSize];
        tag = new int[cacheSize];

    }

    public int writeMem(int address, int data, int write){
        
        if (!checkAddress(address, write))
            return -1;
        
        int index = address & 512;
        int curTag = address >> 1;

        tag[index] = curTag;
        valid[index] = true;
        return cache[index] = dataMemory.write(address, data);

    }

    public int read(int address, int read){
        if (!checkAddress(address, read))
            return -1;

        int index = address & 512;
        int curTag = address >> 1;

        if(!valid[index] || tag[index] != curTag){

            tag[index] = curTag;
            valid[index] = true;
            return cache[index] = dataMemory.read(address);

        }

        else{

                return cache[index];

        }

    }

    public static boolean checkAddress(int address, int signal){

        return address < DataMemory.size && address >= 0 && signal == 1;

    }

}