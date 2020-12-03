with open('input.txt', 'r') as repo:
    repoLst = repo.readlines()

    for i in range(len(repoLst)):
        for j in range(i, len(repoLst)):
            if (int(repoLst[i]) + int(repoLst[j]) == 2020):
                print(int(repoLst[i])*int(repoLst[j]))
                break

    for i in range(len(repoLst)):
        for j in range(i, len(repoLst)):
            for k in range(j, len(repoLst)):
                if (int(repoLst[i]) + int(repoLst[j]) + int(repoLst[k]) == 2020):
                    print(int(repoLst[i])*int(repoLst[j])*int(repoLst[j]))
                    break

