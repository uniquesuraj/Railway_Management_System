package com.suraj.service;

import com.suraj.model.Train;

public interface TrainService {
	Train createTrain(Train train);
    Train getTrain(int trainId);
    Train updateTrain(int trainId, Train train);
    Train deleteTrain(int trainId);
    
}


