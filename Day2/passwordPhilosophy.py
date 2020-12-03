with open('input.txt', 'r') as passLst:
    passAndKeyLst = []
    for line in passLst:
        passAndKeyLst.append(passLst.readline().split(": "))

    valid = 0
    
    for passAndKey in passAndKeyLst:
        let = passAndKey[0][-1]
        mini = int(passAndKey[0][0:passAndKey[0].find("-")])
        maxi = int(passAndKey[0][passAndKey[0].find("-")+1: passAndKey[0].find(" ")])
        find = 0
        for char in passAndKey[1]:
            print(char, passAndKey[1])
            if char == let:
               find += 1
        if mini <= find and find <= maxi:
            valid += 1

    valid2 = 0

    for passAndKey in passAndKeyLst:
        let = passAndKey[0][-1]
        index1 = int(passAndKey[0][0:passAndKey[0].find("-")])
        index2 = int(passAndKey[0][passAndKey[0].find("-"): passAndKey[0].find(" ")])
        find = 0
        if (passAndKey[1][index1] == let or passAndKey[1][index1] == let) and not(passAndKey[1][index1] == let and passAndKey[1][index1] == let):
            valid2 += 1

    print(valid, valid2)
