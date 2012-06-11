/*main method*/
def result(n){
    m1 = []
    m2 = []
    for(def index = 2; index <= n; index++){
        m2 = multiMatrix(m1, m2)
        m1 = getPrimeFactores(index)
    }
    result = 1
    m2.each{
        result*=it
    }
    result
}

def multiMatrix(m1, m2){
    for(index = 0; index < m1.size(); index++){
        for(reg = 0; reg < m2.size(); reg++){
            if(m1.get(index) == m2.get(reg)){
                m2.putAt(reg, 1)
                break
            }
        }
    }
    m1 + m2.findAll{
        it!=1
    }
}

def getPrimeFactores(long n){
    arr = []
    long index = 2;
    while(n != 1){
        if(n%index == 0){
            n/=index
            arr << index
            index = 2
            continue
        }
        index++
    }
    arr
}
/**/
assert getPrimeFactores(2) == [2]
assert getPrimeFactores(3) == [3]
assert getPrimeFactores(4) == [2, 2]
assert getPrimeFactores(5) == [5]
assert getPrimeFactores(6) == [2, 3]
assert getPrimeFactores(7) == [7]
assert getPrimeFactores(8) == [2, 2, 2]
assert getPrimeFactores(9) == [3, 3]
assert getPrimeFactores(10) == [2, 5]
/**/
assert multiMatrix([], []) == []
assert multiMatrix([2], []) == [2]
assert multiMatrix([], [2]) == [2]
assert multiMatrix([2], [3]) == [2, 3]
assert multiMatrix([2, 3], [2, 2]) == [2, 3, 2]
assert multiMatrix([2, 3, 2], [5]) == [2, 3, 2, 5]
assert multiMatrix([2, 3, 2, 5], [2, 3]) == [2, 3, 2, 5]
assert multiMatrix([2, 3, 2, 5], [7]) == [2, 3, 2, 5, 7]
assert multiMatrix([2, 3, 2, 5, 7], [2, 2, 2]) == [2, 3, 2, 5, 7, 2]
assert multiMatrix([2, 3, 2, 5, 7, 2], [3, 3]) == [2, 3, 2, 5, 7, 2, 3]
assert multiMatrix([2, 3, 2, 5, 7, 2, 3], [2, 5]) == [2, 3, 2, 5, 7, 2, 3]
/**/
assert result(10) == (2*3*2*5*7*2*3) //2520
assert result(20) == (2*3*2*5*7*2*3*11*13*2*17*19) //232792560