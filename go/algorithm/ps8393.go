package main

import (
	"fmt"
)

func main(){
	var n int
	fmt.Scanf("%d", &n)

	sum := 0
	for i := 0; i < n; i++ {
		sum += i+1;
	}

	fmt.Println(sum)
}