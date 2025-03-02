class Sort {
    public static void main(String[] args) {

        int[] arr = {64, 34, 25, 12, 22, 11, 90};

//        //选择排序
//        SelectionSort(arr);
//        for(int i=0;i<arr.length;i++){
//        System.out.print(arr[i]+",");
//        }
//        //插入排序
//        InsertSort(arr);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+"-");
//        }

//        //归并排序
//        MergeSort(arr);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+",");
//        }
        //快速排序
        quickSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    private static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int pIndex=partition(arr,left,right);
            quickSort(arr,left,pIndex-1);
            quickSort(arr,pIndex+1,right);
        }
    }
    private static int partition(int[] arr,int left,int right){
        int Index=arr[right];
        int i=left-1;
        for(int j=left;j<right;j++){
            if(arr[j]<Index){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[right];
        arr[right]=temp;
        return i+1;
    }

    private static void MergeSort(int[] arr){
        int n=arr.length;
        if(arr==null||n<2){
            return;
        }
        int[] temp=new int[n];
        MergeSort(arr,0,n-1,temp);

    }
    private static void MergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            MergeSort(arr,left,mid,temp);
            MergeSort(arr,mid+1,right,temp);
            Merge(arr,left,mid,right,temp);
        }

    }
    private static void Merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }
            else{
                temp[t++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[t++]=arr[i++];
        }
        while(j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while(left<=right){
            arr[left++]=temp[t++];
        }
    }

    private static void InsertSort(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }


    static void SelectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }

    }

}