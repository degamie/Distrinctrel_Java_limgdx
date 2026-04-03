//package com.libgdx.discintrel.gwt;
//
//import com.badlogic.gdx.Gdx;
//import com.google.gwt.event.logical.shared.ResizeEvent;
//import com.google.gwt.event.logical.shared.ResizeHandler;
//
//import static sun.security.ssl.SSLExtension.PADDING;
//
//public  class ResizeListener implements ResizeHandler {
//    @Override
//    public void onResize(ResizeEvent event) {
//        if (Gdx.graphics.isFullscreen()) {
//            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
//        } else {
//            int width = event.getWidth() - PADDING;
//            int height = event.getHeight() - PADDING;
//        }
//    }
//
////            getRootPanel().setWidth("" + width + "px");
////            getRootPanel().setHeight("" + height + "px");
////            getApplicationListener().resize(width, height);
////            Gdx.graphics.setWindowedMode(width, height);
////        }
//
