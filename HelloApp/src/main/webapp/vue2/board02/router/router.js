import myBoardList from '../components/myBoardList.js';
import myBoardRead from '../components/myBoardRead.js';
import myBoardWrite from '../components/myBoardWrite.js';

export default new VueRouter({
  routes: [
    //main
    {
      //절대 경로도 지정
      path: '/',
      name: 'main',
      component: {
        template: `<div>
                      <h3>게시판을 불러와주세요</h3>
                    </div>`
      }
    },
    //boardList
    {
      path: '/boardList',
      name: 'boardList',
      component : myBoardList
    },
    //boardRead
    {
      path: '/boardRead/:item',
      name: 'boardRead',
      component : myBoardRead,
      props : true
    },
    //boardWrite
    {
      path: '/boardWrite',
      name: 'boardWrite',
      component : myBoardWrite
    },
    //etc
    //routes에서 정해진 경로 외 경로일 경우 (위에서부터 읽기 시작하기 때문에 가장 마지막에 * 사용)
    //redirect 돌아갈 경로 지정
    {
      path: '*',
      redirect : '/'
    }
  ]
})