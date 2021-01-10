package main

import (
	"fmt"
	"sort"
)

type Student struct {
	Name string
	Class1 int
	Class2 int
	Class3 int
}

// quicksort 알고리즘인데 시간초과..? Go언어로.. PS못해먹겠네
//type Students []Student
//
//func (s Students) Len() int {
//	return len(s)
//}
//
//func (s Students) Less(i, j int) bool {
//	cond1 := s[i].Class1 == s[j].Class1
//	cond2 := s[i].Class2 == s[j].Class2
//	cond3 := s[i].Class3 == s[j].Class3
//
//	if cond1 && cond2 && cond3 {
//		return s[i].Name < s[j].Name
//	} else if cond1 && cond2 {
//		return s[i].Class3 > s[j].Class3
//	} else if cond1 {
//		return s[i].Class2 < s[j].Class2
//	} else {
//		return s[i].Class1 > s[j].Class1
//	}
//}
//
//func (s Students) Swap(i, j int) {
//	s[i], s[j] = s[j], s[i]
//}

func main() {
	var n int
	fmt.Scanf("%d", &n)
	arr := make([]Student, n)

	for i := 0; i < n; i++ {
		fmt.Scanf("%s %d %d %d", &arr[i].Name, &arr[i].Class1, &arr[i].Class2, &arr[i].Class3)
	}

	sort.SliceStable(arr, func(i, j int) bool {
		cond1 := arr[i].Class1 == arr[j].Class1
		cond2 := arr[i].Class2 == arr[j].Class2
		cond3 := arr[i].Class3 == arr[j].Class3

		if cond1 && cond2 && cond3 {
			return arr[i].Name < arr[j].Name
		} else if cond1 && cond2 {
			return arr[i].Class3 > arr[j].Class3
		} else if cond1 {
			return arr[i].Class2 < arr[j].Class2
		} else {
			return arr[i].Class1 > arr[j].Class1
		}
	})

	for _, el := range arr {
		fmt.Println(el.Name)
	}
}
