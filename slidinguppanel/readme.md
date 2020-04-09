## 属性解析
- name="umanoPanelHeight" format="dimension" /> 距离页面顶部高度
- name="umanoShadowHeight" format="dimension" /> 阴影高度
- name="umanoParallaxOffset" format="dimension" /> 设置拖动过程中，主面板也会随着拖动方向移动的距离
- name="umanoFadeColor" format="color" /> 滑动过程中主面板渐变的颜色，默认是透明的，慢慢变暗
- name="umanoFlingVelocity" format="integer" />
- name="umanoDragView" format="reference" /> 设置外层拖拽的view（包含umanoScrollableView）
- name="umanoScrollableView" format="reference" /> 设置可展开的是哪个view
- name="umanoOverlay" format="boolean" /> 是否显示阴影
- name="umanoClipPanel" format="boolean" />
- name="umanoAnchorPoint" format="float" />
- name="umanoInitialState" format="enum"> 您可以通过设置umanoScrollInterpolator属性为面板移动提供滚动内插器，例如：如果你想要一个反弹或过冲效果的面板
        enum name="expanded" value="0" />
        enum name="collapsed" value="1" />
        enum name="anchored" value="2" />
        enum name="hidden" value="3" />
- name="umanoScrollInterpolator" format="reference" />
