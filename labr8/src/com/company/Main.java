package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        int m =1;
        String name;
        int groupn;
        float avg_balls1;
        float avg_balls2;
        int id1;
        int n;
        students student= new students();
        Scanner scanner = new Scanner(System.in);
        students[] student1 = new students[m];
        System.out.print("vvedite kol-vo studentov:");
         n = scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            String q = scanner.nextLine();
            System.out.print("Vvedite familiu:");
            name = scanner.nextLine();
            System.out.print("Vvedite nomer grupi:");
            groupn = scanner.nextInt();
            System.out.print("Vvedite srednii ball za 1 exzamen:");
            avg_balls1 = scanner.nextFloat();
            System.out.print("Vvedite srednii ball za 2 exzamen:");
            avg_balls2 = scanner.nextFloat();
            System.out.print("Vvedire nomer zachetki:");
            id1 = scanner.nextInt();
            student.setStudent(name,i,groupn,avg_balls1,avg_balls2);
            student.student_book.set_id(i,id1);

        }


        System.out.println("Do sortirovki:");
        student.outPut(n);
        student.sort(n);
        System.out.println("posle sortirovki:");
        student.outPut(n);
        student.zadanie(n);
        student.sumofballs(n);

        student.setS(n);
          student.out_stipendia(n);

         System.out.println("Введите фамлию студента:");
        String q = scanner.nextLine();
        for(int i=0;i<m;i++) {
            student1[i] = new students();
            student1[i].st(q = scanner.nextLine());
        }
      for(int i = 0;i< m;i++)
      {
          System.out.println(student1[i].name);

      }
      for(int i = 0; i<m;i++)
      {

          System.out.println("Длинна фамилии:"+ student1[i].name.length());

      }

    }



}


class students{

    String name;
    private  static int stipendia = 2600;
    private String last_name[] = new String[30];
    private static int [] fiplata = new int[30];
    private int group[] = new int[30];
    private float avg_ball1[] = new float[30];
    private float avg_ball2[] = new float[30];


    Students_book student_book = new Students_book();



    public void setStudent(String name,int i,int groupn,float avg_balls1,float avg_balls2){


        last_name[i]=name;
        group[i] = groupn;
        avg_ball1[i] = avg_balls1;
        avg_ball2[i] = avg_balls2;




    }

    public  static void setStipendia(int i,int k){

        fiplata[i] = k;

    }

    public   void setS(int n){

        for(int i =0;i<n;i++){

            if((avg_ball1[i]+avg_ball2[i])/2 >= 4){

                students.setStipendia(i,students.stipendia);


            }
            if((avg_ball1[i]+avg_ball2[i])/2 < 4 ){

                students.setStipendia(i,0);


            }

        }


    }

    public void out_stipendia(int n){

        for(int i =0;i<n;i++){

            System.out.println("Студент:"+ last_name[i]+"Стипендия:"+students.fiplata[i]);

        }

    }


    public void st(String name){

       this.name = name;

   }

    public String  get_st(){

        return name;

    }



    public void outPut(int n){

        for(int i = 0;i<n;i++)
        {

            System.out.println(last_name[i]+"|" + group[i]+ "|" + avg_ball1[i] + "|" + avg_ball2[i] + "|" + student_book.get_id(i));

        }



    }
    public void sort(int n){
        String ln;
        int gn;
        float ab1;
        float ab2;
        int ID,ID1,ID2;
        for(int i = 0; i < n-1; i++)
        {
            for(int j = n-1; j > i; j--)
            {
                if(group[j-1] < group[j])
                {
                    ln = last_name[j-1];
                    last_name[j-1] = last_name[j];
                    last_name[j] = ln;

                    gn = group[j-1];
                    group[j-1] = group[j];
                    group[j] = gn;

                    ab1 = avg_ball1[j-1];
                    avg_ball1[j-1] = avg_ball1[j];
                    avg_ball1[j] = ab1;

                    ab2 = avg_ball2[j-1];
                    avg_ball2[j-1] = avg_ball2[j];
                    avg_ball2[j] = ab2;

                    ID = student_book.get_id(j-1);
                    ID1 = student_book.get_id(j);
                    student_book.set_id(j-1,ID1);
                    student_book.set_id(j,ID);
                }
            }
        }


    }

    public void zadanie(int n){
        System.out.println("Studenti, u kotorix ocenka za 2 examen ni>|<e , chem za 1:");
        for(int i = 0; i < n; i++)
        {
            if(avg_ball2[i]<avg_ball1[i])
            {
                System.out.println(last_name[i]);

            }
        }



    }

    public void sumofballs(int n){
        float sum1 = 0;
        float sum2 = 0;
        for(int i = 0; i< n; i++){

            sum1+=avg_ball1[i];

            sum2+= avg_ball2[i];

        }
        System.out.printf("Summa za 1 examen: %f \n",sum1);
        System.out.printf("Summa za 2 examen: %f \n",sum2);

    }

    public int get_group(int i){


        return group[i];

    }
    class Students_book{

        private int  id[] = new int [30];



        public void  set_id(int i,int id1){

            id[i] = id1;

        }


        public int get_id(int i){

            return id[i];

        }



    }
}

