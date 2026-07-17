    package Linear_Search;

    import java.util.Random;

    public class linearSearch {
        private int[] arr;
        private int searchValue;

        public linearSearch(int size, int searchValue){
            setSize(size);
            setSearchValue(searchValue);
            generateArray();
        }

        public void setSize(int size){
            if(size <= 0){
                throw new IllegalArgumentException("size must > 0");
            }
            arr = new int[size];
        }

        public int[] getLinearSearch(){
            return arr;
        }

        public void setSearchValue(int searchValue){
            if(searchValue < 0){
                throw new IllegalArgumentException("Value must >= 0");
            }
            this.searchValue = searchValue;
        }

        public int getSearchValue(){
            return searchValue;
        }

        public void generateArray(){
            Random rd = new Random();
            for(int i = 0; i < arr.length; i++){
                arr[i] = rd.nextInt(99);
            }
        }

        public int search(){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == searchValue){
                    return i;
                }
            }
            return -1;
        }   

        public void display(){
            System.out.print("[");
            for(int i = 0; i < arr.length; i++){
                if(i < arr.length){
                    System.out.print(arr[i]);
                }
                if(i < arr.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
        }
    }