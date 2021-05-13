package com.gwas.motioncapture;

import com.gwas.motioncapture.IMotionCaptureCallback;

interface IMotionCapture {
    void register(IMotionCaptureCallback callback);
    void unregister(IMotionCaptureCallback callback);
}
