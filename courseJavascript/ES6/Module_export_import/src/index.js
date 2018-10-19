import log, {getTime, getCurretHour, MyLogger} from './myLogger';
import _  from './utility';

const root = document.querySelector('#root');
root.innerHTML = '<p>Hello World ! </p>';

log('hello log');
log(`getTime is ${getTime()}`);
log(getCurretHour());

const logger = new MyLogger();
log(`lecture of CS are ${logger.getLectures()}`);
log(logger.getLectureTime());

_.log('hello _.log');