export default function log(data){
    console.log(data);
}

export const getTime = () => Date.now();

export const getCurretHour = () => (new Date).getHours();

//Class
export class MyLogger {
    constructor(props){
        this.lectures = ['java', 'ios'];
    }
    getLectures(){
        return this.lectures;
    }
    getLectureTime(){
        return Date.now();
    }
}