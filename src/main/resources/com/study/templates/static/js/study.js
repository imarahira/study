/**
 * study.html用 JSクラス
 * jQuery使用
 */

/* ↓↓↓↓定数↓↓↓↓ */

const FLG_OFF = '0';
const FLG_ON = '1';
const STUDENT = '1';
const HOUSE_WIFE = '5';
const NEET = '7';
const BLANK = '';

/* ↑↑↑↑定数↑↑↑↑ */

/* ↓↓関数定義↓↓ */

//画面表示時に動く無名関数内で関数を定義することで画面側の分岐に対応

$(function(){
	
	/*
	//EventListenerに関してはjQueryで書くよりjavascriptの方が良い
	//addEventListenerを通ることで指定したid要素にイベントハンドラを追加
	document.getElementById('').addEventListener('イベントハンドラ',関数名);
	//一度追加したイベントハンドラはremoveEventListenerで削除可能
	document.getElementById('').removeEventListener('イベントハンドラ',関数名);
	*/
	
	document.getElementsById('jobRadioArea').addEventListener('click',jobKbnCheck);

})

/* ↑↑関数定義↑↑ */

/* ↓↓↓↓処理↓↓↓↓ */

/*
 *職業選択時
 *選択項目に応じて年収入力欄を非活性にする
 *
 */
function jobKbnCheck() {
	//name属性一致している要素を取得し、ラジオボタンで選択されている要素に当たるまで繰り返し
	let elements = document.getElementsByName('jobKbn');
	for(let i = 0; i < elements.length; i++) {
		if(elements.item(i).checked) {
			const checkValue = elements.item(i).value;
			if(checkValue == STUDENT
				|| checkValue == HOUSE_WIFE
				|| checkValue == NEET) {
					$('#annualIncome').val(BLANK);//入力されていた場合を考慮し空文字をセット
					$('#annualIncome').prop("disabled", true);//非活性にする
			}
		exit;//処理終了
		}
	}
}

/* ↑↑↑↑処理↑↑↑↑ */