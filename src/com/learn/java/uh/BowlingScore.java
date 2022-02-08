package com.learn.java.uh;

//Write a function that takes a string as input and returns the score for a single game of bowling as an integer.
// The input is a string representing each individual roll of the game. There are no delimiters.
// "134452X-/-1X2/--36"
// 1 3
// 4 4
// 5 2
// X
// - /
// - 1
// X
// 2 /
// - -
// 3 6
// 4 + 8 + 7 + 20 + 10 + 1 + 20 + 10 + 0 + 9 =
public class BowlingScore {
    public static void main(String[] args) {
//        String s= "134452X-/-1X2/--36";
//        String s= "-127369---815411221-";
        String s ="-12/369/--8/5/11221/3"; //78
//        String s="-1X369---XX1122XXX"; //107
//        String s= "X-/X9-8/XX1/7/3/X"; //179
        System.out.println(giveScore(s));
    }
    static int giveScore(String s){
        int score=0;
        char[] chars= s.toCharArray();
        int k=1, c=0, x=0,st=0, prev=0, prevst=0;
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                int score1 = Integer.parseInt(String.valueOf(chars[i]));
                score+= score1;
                prevst=score1;
                if(x==1){
                    score+=score1;
                    x++;
                    prev=score1;

                }else if(x==2){
                    prev=0;
                    score+=score1;
                    x=0;
                }
                else  if(st==1){
                    score+=score1;
                    st=0;
                }
                if(c==1){
                    c=0;
                    k++;
                    prevst=0;
                }else
                    c=1;
            }else if(chars[i]=='X'){
                score+=10;
                if(x==1){
                    score+=10;
                    x++;
                    prev=10;

                }else if(x==2){
                    prev=0;
                    score+=10;
                    x=0;
                }
                if(st==1){
                    score+=10;
                    st=0;
                }
                x++;
                if(k==9 && c==0){
                    c++;
                    continue;
                }else
                    k++;
            }else if(chars[i]=='/'){
                score+=10;
                score=score-prevst;
                if(x==1){
                    score+=10;
                    x++;

                }else if(x==2){
                    score=score-prev;
                    prev=0;
                    score+=10;
                    x=0;
                }
                st=1;
                if(k==9 && c==1){
                    c++;
                    continue;
                }
                if(c==1){
                    c=0;
                    k++;
                }
            }else if(chars[i]=='-'){
                prevst=0;
                if(x==1){
                    score+=0;
                    x++;
                    prev=0;

                }else if(x==2){
                    prev=0;
                    score+=0;
                    x=0;
                }
                else  if(st==1){
                    score+=0;
                    st=0;
                }
                if(c==1){
                    c=0;
                    k++;
                }else
                    c=1;
            }
        }
        return score;
    }
}
