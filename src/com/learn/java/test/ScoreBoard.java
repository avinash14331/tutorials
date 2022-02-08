package com.learn.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreBoard {
    public static void main(String[] args) {
        List<Score> list= new ArrayList<>();
        list.add(new Score(1,"user1"));
        list.add(new Score(2,"user1"));
        list.add(new Score(2,"user2"));
        list.add(new Score(10,"user3"));
        list.add(new Score(10,"user3"));

        List<Score> res=new ArrayList<>();
        for(Score score:list){
            int flag=0;
           for(int i=0;i<res.size(); i++){
               if(res.get(i).value< score.value){
                   res.add(i,score);
                   flag=1;
                   break;
               }
               else if(res.get(i).equals(score))
               {
                   flag=1;
                   break;
               }
               else if(res.get(i).value==score.value && !res.get(i).equals(score)){
                   int v1= Integer.parseInt(res.get(i).user.substring(4));
                   int v2= Integer.parseInt(score.user.substring(4));
                   if(v2<v1){
                       res.add(i,score);
                       flag=1;
                       break;
                   }

               }
           }
           if(flag==0)
               res.add(score);
        }

        System.out.println(res);
    }
    static class Score{
        int value;
        String user;
        public Score(int value, String user){
            this.value=value;
            this.user=user;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Score)) return false;
            Score score = (Score) o;
            return value == score.value && Objects.equals(user, score.user);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, user);
        }

        @Override
        public String toString() {
            return "Score{" +
                    "value=" + value +
                    ", user='" + user + '\'' +
                    '}';
        }
    }

}
