package main

import (
	"fmt"
	"strconv"
)

func main() {
	texts := make([]string, 0)
	result := make([]int, 0)
	i := 0 

	var op string 
	var startOp byte
	fmt.Scanf("%s", &op)
	
	var text string
	for el := range op {
		if op[el] == '+' || op[el] == '-' {
			if startOp == 0 {
				startOp = op[el]
			}

			texts = append(texts, text)
			text = ""
			i += 1
		} else {
			text += string(op[el])
			if el + 1 == len(op) {
				texts = append(texts, text)
			}
		}
	}

	pos := 0
	if startOp == '-' {
		num, _ := strconv.Atoi(texts[pos])
		result = append(result, num)
		pos += 1
	}

	for pos < len(texts) {
		if pos + 1 == len(texts) {
			num, _ := strconv.Atoi(texts[pos])
			result = append(result, num)
		} else {
			a, _ := strconv.Atoi(texts[pos])
			b, _ := strconv.Atoi(texts[pos+1])
			result = append(result, a + b)
			pos += 2
		}
	}

	ans := 0
	for i, val := range result {
		if i == 0 {
			ans = val
		} else {
			ans = ans - val
		}
	}

	fmt.Println(ans)
}