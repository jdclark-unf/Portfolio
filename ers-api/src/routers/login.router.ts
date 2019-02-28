import express from 'express';
import * as LoginDao from '../dao/login.dao';
import path from 'path';

export const loginRouter = express.Router();

loginRouter.post('', async (req, res) => {
  // console.log(req.body); // print request body for debugging
  const user = await LoginDao.authenticate(req.body.username); // function returns a User object
  // console.log(user); // for debugging
  if (req.body.password === user.password) {
    user.password = ''; // don't keep carrying around password on user object
    req.session.user = user; // attach user to session object
    // res.json(user);
    res.sendFile(path.join(__dirname, '../views', 'index.html'));
  } else {
    res.status(400); // bad request
    res.send('Invalid Credentials');
  }
});

// Copied from poke-api, not sure what it is for
loginRouter.get('/info', (req, res) => {
  res.json(req.session.user);
});