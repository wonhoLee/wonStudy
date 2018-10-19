import log, {getTime, getCurretHour, MyLogger, _} from './myLogger';

const root = document.querySelector('#root');
root.innerHTML = '<p>Hello World ! </p>';

log('hello log');
log(`getTime is ${getTime()}`);
log(getCurretHour());

const logger = new MyLogger();
log(`lecture of CS are ${logger.getLectures()}`);
log(logger.getLectureTime());

_.log('hello _.log');