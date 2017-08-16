/*==========================================================|
| AUTHOR:- RAVI SHANKAR, MAYANK SHARMA, VAMSHI SAI REDDY    |
| TEAM :- VISION @NIT JALANDHAR CSE PRE-FINAL YEAR STUDENTS |
===========================================================*/
import java.util.*;
import Parking.*;
class EntryServerThread extends Thread
{
    SegQuery sq; int[] arr; int[] st; int n;
    SaveEntryExit see;
    public void run()
    {
        EntryServer es=new EntryServer(sq,st,n,arr,see);
    }
    public void get(SegQuery sq,int[] arr,int[] st,int n,SaveEntryExit see)
    {
        this.sq=sq;
        this.arr=arr;
        this.st=st;
        this.n=n;
        this.see=see;
    }
}
class ExitServerThread extends Thread
{
    SegQuery sq; int[] arr; int[] st; int n;
    SaveEntryExit see;
    public void run()
    {
        ExitServer es=new ExitServer(sq,st,n,arr,see);
    }
    public void get(SegQuery sq,int[] arr,int[] st,int n,SaveEntryExit see)
    {
        this.sq=sq;
        this.arr=arr;
        this.st=st;
        this.n=n;
        this.see=see;
    }
}
class car_parking
{
 public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    SegQuery mst=new SegQuery();
    SaveEntryExit see=new SaveEntryExit();
    System.out.println("==================WELCOME TO CAR PARKING MANAGEMENT SYSTEM==================");
    System.out.println("Enter basic details : ");
    System.out.print("Enter total number of lots : ");
    int n;  n=sc.nextInt();
    System.out.print("Enter number of Entry gate : ");
    int entry; entry=sc.nextInt();
    System.out.print("Enter number of Exit gate : ");
    int exit; exit=sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++) arr[i]=0; //Initially all lots are free
    int st[]=new int[4*n];
    mst.makes(arr,0,n-1,st,0);
    //Declaration of object of Thread class
    EntryServerThread est=new EntryServerThread();
    ExitServerThread ext=new ExitServerThread();
    //Initialization of Thread object
    est.get(mst,arr,st,n,see);
    ext.get(mst,arr,st,n,see);
    //Running Threads
    est.start();
    ext.start();
 }
}
