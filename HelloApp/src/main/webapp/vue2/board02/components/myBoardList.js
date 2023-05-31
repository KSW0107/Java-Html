//외부에서도 js 파일 정보에 접근가능
export default {
  //파일을 분리시켰기때문에 컴포넌트 생성시 사용할 name 지정
  name : 'my-board-list',
  template: `<div>
                      <table id="list">
                          <tr>
                              <th style="width:50px;">글번호</th>
                              <th>글제목</th>
                              <th style="width:50px;">조회수</th>
                              <th style="width:70px;"></th>
                          </tr>
                          <tr v-for="item in object" v-bind:key="item.no">
                              <td>{{item.no}}</td>
                              <router-link tag="td"
                                              v-bind:to="{name : 'boardRead' , params : {item : item}}">
                                              {{item.title}}</router-link>
                              <td>{{item.view}}</td>
                              <td><button v-on:click="boardDelete(item.no)">삭제</button></td>
                          </tr>
                      </table>
                      <!-- <button style="float:right;" v-on:click="boardWrite">글쓰기</button> -->
                      <router-link tag="button" to="/boardWrite" style="float:right;">글쓰기</router-link>
                  </div>`,
      data : function () {
        return {
          object : []
        }
      },
      created : function () {
        //여기서의 $parent = app 파일의 vue 객체
        this.object = this.$parent.getDataArray();
      },
      methods: {
        boardDelete : function (no) {
          for (let i = 0; i < this.object.length; i++) {
            if (this.object[i].no == no) {
              this.object.splice(i, 1);
            }
          }
          this.$parent.setDataArray(this.object)
        }
      }
}