# 2048

세 개의 탭(phone, gallery, 2048)으로 이루어진 애플리케이션입니다.
+ 원하는 연락처를 추가로 저장하고 이미지를 확대해서 볼 수 있습니다.
+ 2048 탭에서는 기존의 2048 게임을 버튼을 눌러 플레이 할 수 있습니다.

![all](https://user-images.githubusercontent.com/105411573/177317662-860a6127-a29c-49bb-92e0-e6bf42a11ff2.jpeg)

#### 개발팀원
  + 한양대 컴퓨터소프트웨어학부 남하욱
  + KAIST 전산학부 이가현

#### 개발환경
  + OS: Android (minSdk: 21, targetSdk: 32)
  + Language: Kotlin
  + IDE: Android Studio
  + Target Device: Galaxy S7

## Tab1 - Phone

![tab1](https://user-images.githubusercontent.com/105411573/177317767-d0e96929-c196-4c7c-8728-07ebbb57855e.jpeg)

#### Major features
+ 애플리케이션 안의 json 파일의 data를 가져와 listview로 보여줍니다.
+ 메인 화면에는 저장되어 연락처의 이름만 보이며, 이름으로 정렬되어 있습니다.
  + 각각의 연락처를 누르면 상세정보(이미지, 이름, 연락처)가 적혀있는 화면이 뜹니다.
    + 왼쪽 상단의 뒤로가기 버튼을 통해서 다시 전 화면으로 돌아갈 수 있습니다.
+ 오른쪽 하단의 + 버튼을 통해 새로운 연락처(이름, 연락처)를 추가할 수 있습니다.
  + 이때 사진은 애플리케이션의 defalt 사진(mario)으로 추가됩니다.
  
#### 기술설명
1. ViewPager2 & Tablayout
> ViewPager2와 tablayout을 통해 3개의 탭(fragment)을 구현하였습니다. viewpager2를 각각의 fragment와 연동하여 탭을 클릭했을 때뿐만 아니라 스와이프를 통해서도 탭 전환이 가능하게 했습니다.
2. Listview
> Adapter를 이용해 데이터와 각 리스트(연락처)의 view를 연결해 listview를 구현했습니다.
3. Intent(subactivity)
> 이동할 subactivity class를 선언하고 intent를 통해 이를 호출해 subactiviy를 구현했습니다.

## Tab 2 - Gallery

<img width="704" alt="tab2" src="https://user-images.githubusercontent.com/105411573/177317810-792fa07c-bed3-4e68-af2e-ca32d79770b4.png">

#### Major features
+ 애플리케이션 안(drawable 폴더)의 이미지 파일의 data를 가져와 gridview로 보여줍니다.
+ 각 이미지를 클릭하면 확대된 화면이 뜨며, 한 번 더 누르며 메인 화면으로 돌아갑니다.

#### 기술설명
1. Gridview
> tab1처럼 adapter를 이용해 gridview를 구현했습니다.
2. tab1처럼 intent를 통해 subactivity를 구혔했습니다.

## Tap3 - 2048 게임

![tab3](https://user-images.githubusercontent.com/105411573/177319349-b50131e2-02f5-4349-b611-031ad3111182.jpeg)

#### Major features
+ 기존의 2048과 유사하게 상하좌우로 움직여서 같은 숫자의 block을 합쳐 점수를 얻는 게임입니다.
+ 상하좌우 버튼을 중 하나를 누르면 그 방향으로 동작하고, 이동이 성공적으로 종료되면 빈 칸에 랜덤하게 2 또는 4가 나타납니다.
+ 만약 움직이려는 방향으로 움직여도 바뀌는 것이 없을 때에는 아무 동작도 하지 않습니다.
+ 현재 상황에서 아무 동작을 할 수 없으면 GameOver 화면이 뜹니다.
+ GameOver 화면은 다시 한 번 클릭하면 꺼지며 Tap3로 돌아갑니다.
+ Reset 버튼을 누르면 게임을 다시 시작할 수 있습니다.


#### 기술 설명
1. 숫자에 따른 색상 변경
>+ 각 grid의 숫자에 따라 색상이 바뀌도록 구현하였습니다.
>+ 숫자가 0 이상인 grid만 숫자를 표시하지 않도록 하였습니다.

2. 동작 알고리즘
>+ 각 동작 방향과 평행하게 4x4 grid를 4칸짜리 배열 4개로 만듭니다(makeArray() 함수)
>+ 각 배열은 서로 영향을 안 미치지므로 이 4칸짜리 배열의 값을 기준으로 동작을 수행하고 바뀐 값들이 저장되어 있는 배열 return하는 함수 doAction()을 구현하였습니다.
>+ doAction()
>> 1) 변수 v,c를 선언하여 각 단계에서 변경할 index를 저장합니다. ( 초기값 v = -1, c = 0 )
>> 2) 빈칸은 의미가 없으므로 배열을 순차적으로 돌며 가장 처음 빈칸이 아닌 index 값을 찾아 v에 저장합니다.
>> 3) v가 음수면 빈칸이므로 그냥 return, v가 3이면 마지막 값만 첫번째로 옮기고 return
>> 4) for ( v+1 .. 3 ) 을 통해 순회하며 각 단계를 수행합니다.
>> 5) 현재 보는 배열 값 atomicArray[i]와 합쳐질 가능성이 있는 배열 값 atomicArray[v]을 비교하여 같으면 합치고, 다르면 atomicArray[v]값은 저장하고 v=i가 되어 다시 수행, atomicArray[i]가 0이면 넘깁니다.

3. 동작 후 새로운 숫자 생성
>+ grid를 전체 탐색하여 값이 0인 index 값들만 가지는 int형 배열을 만듭니다.
>+ 이 배열의 size 보다 작은 값을 random으로 얻은 값은 빈 칸중 랜덤한 index입니다.
>+ 0,1 중의 값을 랜덤하게 얻어서 0이면 2, 1이면 4를 grid의 index에 추가합니다.
>+ 만약 빈 칸의 개수가 1 (size가 1)이면 gameover 함수를 호출하여 gameover를 체크합니다.

4. 모든 동작 후 Grid에 반영
>+ Adapter를 다시 호출하여 현재 gridView에 바뀐 gridArray를 보여지게 하였습니다.
