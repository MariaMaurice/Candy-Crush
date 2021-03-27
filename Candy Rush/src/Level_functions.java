
public class Level_functions extends game_functions
{
     public static int score=0;
     public static int target=50;

    static public  int getScore() {
        return score;
    }
     
     @Override
     public void removeCrushedCandy(Candy candy[][] , int row, int col) {

			for (int j = col; ; j--) {
                            if (j == 0){
                                candy[row][j].type =10;
                                break;
                            }
			    candy[row][j].type= candy[row][j-1].type ;
                            candy[row][j].special= candy[row][j-1].special ;
			}

		
	}  
    
     @Override
     public boolean bool_horizontal_check(int row,int col,Candy candy[][]){
        // 2 on right
        if(col<=1&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type)
            return true;
        
        else if(col>=2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col-2].type)
            return true;
        
        else if(col>=1&&col<=2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type)
            return true;
        
        else 
            return false;
    }
     @Override
      public boolean bool_vertical_check(int row,int col,Candy candy[][]){
        //2 on top
		if (row >= 2 && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type)
			return true;
		//2 on bottom
		else if(row <=1 && candy[row+1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type)
			return true;
		//1 each on top and bottom
		else if(row >= 1 && row <=2 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type)
			return true;
		else
			return false;
	}
    
     @Override
      public void horizontal_check(int row,int col,Candy candy[][]){
        
        
        if(col<=1&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type){
            effect (row ,col,candy);
            effect (row ,col+1,candy);
            effect (row ,col+2,candy);
             score+=3;
     
        }
      
        else if(col>=2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col-2].type){
             effect (row ,col,candy);
             effect (row ,col-1,candy);
             effect (row ,col-2,candy);
              score+=3;
        }
      
        else if(col>=1&&col<=2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type){
            effect (row ,col,candy);
            effect (row ,col-1,candy);
            effect (row ,col+1,candy);
             score+=3;
        }
            
        
    }
     @Override
    public void vertical_check(int row,int col,Candy candy[][]){
        //2 on top
		if (row >= 2 && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type){
                   effect (row ,col,candy);
                   effect (row-1 ,col,candy);
                   effect (row -2,col,candy);
                   
                   score+=3;
                }
			
		//2 on bottom
		else if(row <=1 && candy[row+1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type){
                    effect (row ,col,candy);
                    effect (row+1 ,col,candy);
                    effect (row+2 ,col,candy);
                   
                    score+=3;
           
                }
			
		//1 each on top and bottom
		else if(row >= 1 && row <=2 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type){
                     effect (row ,col,candy);
                     effect (row+1 ,col,candy);
                     effect (row-1,col,candy);
                 
                 score+=3;
                }
			
		
	}
      
     @Override
    public boolean win(){
        if(score>=target)
            return true;
        else
            return false;
    } 
    
     @Override
     public void horizontal_4_check(int row,int col,Candy candy[][]){
        
        
        if(col==0&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type&&candy[row][col].type==candy[row][col+3].type){
            
             candy[row][col].special = true;
             
             effect (row ,col+3,candy);
            effect (row ,col+1,candy);
            effect (row ,col+2,candy);
             score+=5;
             
             
        }
            
        
        else if(col==3&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col-2].type &&candy[row][col].type==candy[row][col-3].type){
          
             candy[row][col].special = true;
            
              effect (row ,col-3,candy);
            effect (row ,col-1,candy);
            effect (row ,col-2,candy);
             
              score+=5;
        }
           
        
        else if(col==1&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type){
           
             candy[row][col].special = true;
           
              effect (row ,col-1,candy);
              effect (row ,col+1,candy);
              effect (row ,col+2,candy);
             score+=5;
        }
        else if(col==2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col-2].type){
          
             candy[row][col].special = true;
            
              effect (row ,col+1,candy);
              effect (row ,col-1,candy);
              effect (row ,col+2,candy);
             score+=5;
        }
            
        
    }
     @Override
      public void vertical_4_check(int row,int col,Candy candy[][]){
        //2 on top
		if (row == 4 && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type && candy[row-3][col].type == candy[row][col].type){
                
                    candy[row][col].special = true;
                     effect (row-3 ,col,candy);
                     effect (row-1 ,col,candy);
                     effect (row-2 ,col,candy);
                   
                   score+=5;
                }
			
		//2 on bottom
		else if(row ==0 && candy[row+1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type && candy[row+3][col].type == candy[row][col].type){
                
                     candy[row][col].special = true;
                      effect (row+3 ,col,candy);
                      effect (row+1 ,col,candy);
                      effect (row +2,col,candy);
                    score+=5;
           
                }
			
		//1 each on top and bottom
		else if(row == 1 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type){
                 
                    candy[row][col].special = true;
                     effect (row+2 ,col,candy);
                     effect (row+1 ,col,candy);
                     effect (row-1 ,col,candy);
                 score+=5;
                }
                
                else if(row == 2 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type){

                     candy[row][col].special = true;
                 
                      effect (row-2 ,col,candy);
                      effect (row+1 ,col,candy);
                      effect (row-1 ,col,candy);
                 score+=5;
                }
			
		
	}
    
     @Override
    public boolean bool_horizontal_4_check(int row,int col,Candy candy[][]){
        
        
         if(col==0&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type&&candy[row][col].type==candy[row][col+3].type){
        
                    return true;
             
        }
            
        
        else if(col==3&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col-2].type &&candy[row][col].type==candy[row][col-3].type){
            
                    return true;
        }
           
        
        else if(col==1&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col+2].type){
          
                    return true;
        }
        else if(col==2&&candy[row][col].type==candy[row][col-1].type&&candy[row][col].type==candy[row][col+1].type&&candy[row][col].type==candy[row][col-2].type){
         
                    return true;
        }
            
        else
            return false;
            
        
    }
    
     @Override
     public boolean bool_vertical_4_check(int row,int col,Candy candy[][]){
        //2 on top
		if (row == 3 && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type && candy[row-3][col].type == candy[row][col].type){
               
                    return true;
                }
			
		//2 on bottom
		else if(row ==0 && candy[row+1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type && candy[row+3][col].type == candy[row][col].type){
                    
                    return true;
           
                }
			
		//1 each on top and bottom
		else if(row == 1 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type && candy[row+2][col].type == candy[row][col].type){
                  
                    return true;
                }
                
                else if(row == 2 &&candy[row+1][col].type == candy[row][col].type && candy[row-1][col].type == candy[row][col].type && candy[row-2][col].type == candy[row][col].type){
                   
                    return true;
                }
			
                else
                    return false;
			
		
	}
    
     @Override
     public void re_fill(Candy candy[][]){
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            candy[i][j].type=(int)(6 * Math.random());
                    candy[i][j].getImage_view();
        }
            
    }
    
    
    
} 
   

     @Override
     public void special (int row , int col , Candy candy[][]){
        candy[1][col].type =10;
        candy[2][col].type =10;
        candy[3][col].type =10;
        candy[0][col].type =10;
        removeCrushedCandy(candy , col, 0);
        removeCrushedCandy(candy , col, 1);
        removeCrushedCandy(candy , col, 2);
        removeCrushedCandy(candy , col, 3);
        candy [row][col].special =false;
        score+=4;
    }
     @Override
     public void effect (int row , int col , Candy candy[][] ){
          if (candy[row][col].special == true){
                 special(row , col ,candy);
             }
             else{
                  candy[row][col].type=10;
                  removeCrushedCandy(candy , row, col);
             }
    } 
    
} 			
    
 
