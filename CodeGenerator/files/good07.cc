int readInt(){
return 1;
} 

int printInt(int i){
return i;
}

int main ()
{
  int x = readInt () ;

  int d = x/2 ;

  while (d > 1) {
    if (d * (x/d) == x)
      printInt(d) ;
    else
      {}

    d-- ;
  }

}
