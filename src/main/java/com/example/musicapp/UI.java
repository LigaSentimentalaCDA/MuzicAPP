package com.example.musicapp;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;

import javax.swing.text.Position;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.scene.Node;

public class UI extends Application implements Runnable
{  static   Boolean play,pause;
      final String style="-fx-background-color: transparent;-fx-background-radius: 10;-fx-border-color:transparent;-fx-border-radius:10;";
       final String style2="-fx-background-color: gray;-fx-background-radius: 10;-fx-border-color:transparent;-fx-border-radius:10;";
       final String []CBt={"Acasa","Exploreaza","Biblioteca"};
         String sizepath;
    static   Slider sd=new Slider();
   static Clip mp;
   static AudioInputStream audio;

       boolean ok;
      static ArrayList<Thread>g=new ArrayList<Thread>();
     FileInputStream[]fs;
     Image[]img;
     ImageView[] imgpz;
      File[]mz;
    Pane muzica2contentp1;
     public UI(){
         mz=new File[9];
         muzica2contentp1=new Pane();
         muzica2contentp1.setPrefSize(500,300);
         fs=new FileInputStream[2];
         img=new Image[2];
         imgpz=new ImageView[2];
         mz=new File[9];
         for(int i=0;i<9;i++){

             //mz[i]=new File("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/Muzica/m"+(i+1)+".wav");
             //  System.out.println("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/Muzica/m"+(i+1)+".wav");
             mz[i]=new File("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/Muzica/m"+(i+1)+".wav");
         }
         try{
             fs[0]=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/play.png");
             fs[1]=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/pause.png");

         }catch(FileNotFoundException e){
             System.out.println("MSS");
             System.exit(1);
         }
         img[0]=new Image(fs[0]);
         img[1]=new Image(fs[1]);
         imgpz[0]=new ImageView(img[0]);
         imgpz[1]=new ImageView(img[1]);
         sd.applyCss();
         sd.layout();

     }
     public UI(AudioInputStream audio,Clip mp){
         super();
         this.audio=audio;
         this.mp=mp;

     }

    @Override
    public void start(Stage fereastra) throws Exception{

        FileInputStream test,icon2,icon3,test2,icon4,icon5,icon6,icon32;
        File testaudio;
        GridPane muzica2content=new GridPane();
        Pane muzica2contentp2=new Pane();
       Button m2p2b1=new Button();
       Button m2p2b2=new Button();
       Button m2p2b3=new Button();
       m2p2b1.setPrefSize(80,80);
        m2p2b2.setPrefSize(80,80);
        m2p2b3.setPrefSize(80,80);
        m2p2b1.setLayoutY(100);
        m2p2b1.setLayoutX(200);
        m2p2b2.setLayoutY(100);
        m2p2b2.setLayoutX(120);
        m2p2b3.setLayoutY(100);
        m2p2b3.setLayoutX(280);
        m2p2b1.setStyle("-fx-background-radius: 50%;-fx-background-color: white;");
        m2p2b2.setStyle("-fx-background-radius: 50%;-fx-background-color: white;");
        m2p2b3.setStyle("-fx-background-radius: 50%;-fx-background-color:white;");
        m2p2b1.setOnMouseClicked(e->{play(m2p2b1);});
        muzica2contentp2.setPrefSize(500,200);
        muzica2contentp2.setStyle("-fx-background-color: yellow;");
        sd.setPrefSize(500,20);
        muzica2content.setStyle("-fx-background-color: blue");
        muzica2content.setPrefSize(500,500);
        muzica2content.setMaxSize(500,500);
        Button[]butoane=new Button[3];
        Button[]bmz=new Button[9];
        Button playlist=new Button("Playlist");
        playlist.setStyle("-fx-background-radius: 30;-fx-background-color: gray;");
        playlist.setPrefSize(200,50);
        StackPane configs=new StackPane();
        FlowPane[]row=new  FlowPane[3];
        GridPane slotmuzica=new GridPane();
        slotmuzica.setLayoutX(20);
        slotmuzica.setLayoutY(160);
        slotmuzica.setVgap(50);
        slotmuzica.setPrefSize(1920-500,520);
        TextField search=new TextField();
      search.setPrefSize(500,40);
      search.setLayoutX(100);
      search.setLayoutY(10);
      search.setStyle("-fx-background-radius: 5;-fx-background-color:derive(gray,15%);");
      search.setPromptText("    Cauta Muzica and other shits");

        try{
             test=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/i1.png");
             icon2=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/plus.png");
             icon3=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/play.png");
             test2=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/MSS.jpg");
              icon4=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/pause.png");
              icon5=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/back.png");
                icon6=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/forward.png");
              testaudio=new File("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/Test2.wav");
            icon32=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/play.png");
        }catch(FileNotFoundException e){
            System.err.println("Nu e");
            System.exit(1);
        }finally {
            test=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/i1.png");
            icon2=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/plus.png");
            icon3=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/play.png");
            test2=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/MSS.jpg");
            testaudio=new File("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/Test2.wav");
            icon4=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/pause.png");
            icon5=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/back.png");
            icon6=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/forward.png");
            icon32=new FileInputStream("C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/icons/play.png");
        }

        Image ic3=new Image(icon32);
        Image ic4=new Image(icon4);
        Image ic5=new Image(icon5);
        Image ic6=new Image(icon6);
        ImageView pz3=new ImageView(ic3);
        ImageView pz4=new ImageView(ic4);
        ImageView pz5=new ImageView(ic5);
        ImageView pz6=new ImageView(ic6);
        m2p2b1.setGraphic(pz3);
        m2p2b2.setGraphic(pz5);
        m2p2b3.setGraphic(pz6);
        Pane root=new Pane();
        Pane meniu =new Pane();
        Pane player=new Pane();
        Pane muzica =new Pane();
        BorderPane muzica2=new BorderPane();
        Image poza=new Image(test);
        Image poza2=new Image(icon2);
        ImageView[]imageView=new ImageView[3];
         Panels(muzica,player,meniu,muzica2);
        seteazaButoanePlayer(bmz,icon3,muzica,muzica2);
          GridPane gP=new GridPane();
          gP.setPrefSize(200,100);
          for(int i=0;i<3;i++){
              butoane[i]=new Button(CBt[i]);
               imageView[i]=new ImageView(poza);
              butoane[i].setPrefSize(200,30);
              butoane[i].setGraphic(imageView[i]);
              butoane[i].setStyle(style);
              switch(i){
                  case 0:{
                      butoane[0].setOnMouseEntered(e->{schimba1(butoane[0]);});
                      butoane[0].setOnMouseExited(e->{schimbai1(butoane[0]);});
                      butoane[0].setOnMouseClicked(e->{home(muzica2,muzica);});
                      break;
                  }
                  case 1:{
                      butoane[1].setOnMouseEntered(e->{schimba2(butoane[1]);});
                      butoane[1].setOnMouseExited(e->{schimbai2(butoane[1]);});
                      break;
                  }
                  case 2:{
                      butoane[2].setOnMouseEntered(e->{schimba3(butoane[2]);});
                      butoane[2].setOnMouseExited(e->{schimbai3(butoane[2]);});
                      break;
                  }
              }
              gP.add(butoane[i],0,i);
          }
          for(int i=0;i<3;i++){
              row[i]=new FlowPane();
              row[i].setHgap(100);
              row[i].setPrefWidth(1920-500);
              row[i].setPrefHeight(150);
              for(int j=3*i;j<3*(i+1);j++){
                  row[i].getChildren().add(bmz[j]);
              }
              slotmuzica.add(row[i],0,i);
          }
          ImageView ic=new ImageView(poza2);
          playlist.setGraphic(ic);
          gP.add(playlist,0,3);
          gP.setLayoutY(100);
          muzica.setVisible(true);
         meniu.getChildren().add(gP);
         muzica.getChildren().add(search);
         root.getChildren().add(meniu);
         root.getChildren().add(muzica);
         root.getChildren().add(player);
         root.getChildren().add(muzica2);
         muzica.getChildren().add(slotmuzica);
         muzica2content.add(muzica2contentp1,0,0);
         muzica2contentp2.getChildren().add(sd);
         muzica2contentp2.getChildren().add(m2p2b1);
         muzica2contentp2.getChildren().add(m2p2b2);
         muzica2contentp2.getChildren().add(m2p2b3);
         muzica2content.add(muzica2contentp2,0,1);
         muzica2.setCenter(muzica2content);
         BorderPane.setAlignment(muzica2content,Pos.CENTER);
        Scene content=new Scene(root,1320,720);
        fereastra.setScene(content);
        fereastra.setResizable(false);
        fereastra.setTitle("MSSPlayer");
     fereastra.show();




    }
    @Override
    public void run() {
           int k=g.size()-1;
           play = true;
           pause = false;
               mp.start();
               while (mp.getMicrosecondPosition() <= mp.getMicrosecondLength()&&g.get(k).isInterrupted()==false) {

                   sd.setValue((double) mp.getMicrosecondPosition() * 100 / mp.getMicrosecondLength());



               }
               mp.stop();







    }

    public static void main(){

         g.add(new Thread(new UI(audio,mp)));

    }
    private void schimba1(Button x){
        x.setStyle(style2);
    }
    private void schimba2(Button x){
        x.setStyle(style2);
    }
    private void schimba3(Button x){
        x.setStyle(style2);
    }
    private void schimbai1(Button x){
        x.setStyle(style);
    }
    private void schimbai2(Button x){
        x.setStyle(style);
    }
    private void schimbai3(Button x){
        x.setStyle(style);
    }

    private void Panels(Pane muzica,Pane player,Pane meniu,Pane muzica2){
        muzica.setStyle("-fx-background-color:linear-gradient(to bottom,black 0%,gray 0% ,black 40%,gray 40%,black 40%,black 100%);");
        muzica.setPrefSize(1320-200,720);
        muzica2.setPrefSize(1320-200,720);
        player.setPrefSize(1320,1080-720);
        meniu.setPrefSize(200,720);
        meniu.setLayoutX(0);
        meniu.setLayoutY(0);
        muzica.setLayoutX(200);
        muzica.setLayoutY(0);
        muzica2.setLayoutX(200);
        muzica2.setLayoutY(0);
        player.setLayoutX(0);
        player.setLayoutY(720);
        player.setStyle("-fx-background-color: gray");
        meniu.setStyle("-fx-background-color:black");
        muzica2.setStyle("-fx-background-color:red;");
        muzica.setVisible(true);
        muzica2.setVisible(false);
    }

  private void seteazaButoanePlayer(Button[] b,FileInputStream ic,Pane muzica,Pane muzica2) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException {
        Image poza3=new Image(ic);
        ImageView[]icon=new ImageView[9];

        for(int i=0;i<b.length;i++){
            icon[i]=new ImageView(poza3);
            b[i]=new Button();
           b[i].setPrefSize(300,150);
           switch(i){
               case 0:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner1.jpg');-fx-background-position: cover;");

                    b[i].setOnMouseClicked(e->{
                        try{
                            btn1(mz[0],muzica2,muzica);
                        }catch(IOException m){

                        }catch(UnsupportedAudioFileException f){

                        }
                        catch(LineUnavailableException l){

                        }
                        catch(InterruptedException ie){

                        }
                       });

                   break;
               case 1:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner2.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{
                       try{
                           btn2(mz[1],muzica2,muzica);
                       }
                       catch(IOException m){

                       }catch(UnsupportedAudioFileException f){

                       }
                       catch(LineUnavailableException l){

                       }
                       catch(InterruptedException ie){

                       }

                   });
                   break;
               case 2:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner3.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{try{
                       btn3(mz[2],muzica2,muzica);
                   }catch(IOException m){

                   }catch(UnsupportedAudioFileException f){

                   }
                   catch(LineUnavailableException l){

                   }
                   catch(InterruptedException ie){

                   }

                   });
                   break;
               case 3:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner4.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{try{
                       btn4(mz[3],muzica2,muzica);
                   }catch(IOException m){

                   }catch(UnsupportedAudioFileException f){

                   }
                   catch(LineUnavailableException l){

                   }
                   catch(InterruptedException ie){

                   }

                   });
                   break;
               case 4:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner5.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{
                      try{
                          btn5(mz[4],muzica2,muzica);
                      }catch(IOException m){

                      }catch(UnsupportedAudioFileException f){

                      }
                      catch(LineUnavailableException l){

                      }
                      catch(InterruptedException ie){

                      }

                   });
                   break;
               case 5:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner6.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{
                       try{
                           btn6(mz[5],muzica2,muzica);
                       }catch(IOException m){

                       }catch(UnsupportedAudioFileException f){

                       }
                       catch(LineUnavailableException l){

                       }
                       catch(InterruptedException ie){

                       }

                   });
                   break;
               case 6:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner7.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{
                       try{
                           btn7(mz[6],muzica2,muzica);
                       }catch(IOException m){

                       }catch(UnsupportedAudioFileException f){

                       }
                       catch(LineUnavailableException l){

                       }
                       catch(InterruptedException ie){

                       }

                   });
                   break;
               case 7:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner8.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{try{
                       btn8(mz[7],muzica2,muzica);
                   }catch(IOException m){

                   }catch(UnsupportedAudioFileException f){

                   }
                   catch(LineUnavailableException l){

                   }
                   catch(InterruptedException ie){

                   }

                   });
                   break;
               case 8:
                   b[i].setStyle("-fx-background-image: url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner9.jpg');-fx-background-position: cover;");
                   b[i].setOnMouseClicked(e->{
                      try{
                          btn9(mz[8],muzica2,muzica);
                      }catch(IOException m){

                      }catch(UnsupportedAudioFileException f){

                      }
                      catch(LineUnavailableException l){

                      }
                      catch(InterruptedException ie){

                      }

                   });
                   break;
           }
           b[i].setGraphic(icon[i]);



        }

  }
  private void play(Button b){
         if(play==true){
             mp.stop();
             b.setGraphic(imgpz[0]);
             play=false;
             pause=true;
         }else if(pause==true){
             mp.start();
             play=true;
             b.setGraphic(imgpz[1]);
             pause=false;
         }

  }
  private void seteazaMuzica(File mz) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
      main();

        if(g.size()>=2){
         if(g.get(g.size()-2).isInterrupted()==false){
             g.get(g.size()-2).interrupt();


         }
        }
      //  System.out.println(mz.getAbsolutePath());
      audio=AudioSystem.getAudioInputStream(mz.getAbsoluteFile());
      mp=AudioSystem.getClip();
      sd.setValue(0);
      mp.open(audio);

      g.get(g.size()-1).start();



  }
  private void btn1(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
         seteazaMuzica(g);
      muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner1.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
      pm.setVisible(false);
      pn.setVisible(true);
  }
  private void btn2(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
         seteazaMuzica(g);
      muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner2.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
      pm.setVisible(false);
      pn.setVisible(true);

  }
  private void btn3(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
         seteazaMuzica(g);
      muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner3.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
      pm.setVisible(false);
      pn.setVisible(true);

  }
  private void btn4(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
        seteazaMuzica(g);
      muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner4.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
      pn.setVisible(true);


    }
    private void btn5(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
        seteazaMuzica(g);
        muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner5.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
        pn.setVisible(true);

    }
    private void btn6(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
        seteazaMuzica(g);
        muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner6.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
        pn.setVisible(true);
    }
    private void btn7(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
        seteazaMuzica(g);
        muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner7.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
        pn.setVisible(true);
    }
    private void btn8(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
        seteazaMuzica(g);
        muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner8.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
        pn.setVisible(true);
    }
    private void btn9(File g,Pane pn,Pane pm) throws UnsupportedAudioFileException,IOException,LineUnavailableException,InterruptedException{
         seteazaMuzica(g);
        muzica2contentp1.setStyle("-fx-background-image:url('file:C:/Users/AlexandruFlorin/IdeaProjects/MusicAPP/src/main/java/com/example/musicapp/FolderConvertit/baner9.jpg');-fx-background-repeat: no-repeat;-fx-background-size: cover;");
        pm.setVisible(false);
        pn.setVisible(true);
    }
    private void home(Pane pn,Pane pm){
         pn.setVisible(false);
         pm.setVisible(true);
    }

}

