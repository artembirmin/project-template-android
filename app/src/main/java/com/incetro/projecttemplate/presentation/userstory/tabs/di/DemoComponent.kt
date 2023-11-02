/*
 * ProjectTemplate
 *
 * Created by artembirmin on 6/11/2022.
 */

package com.incetro.projecttemplate.presentation.userstory.tabs.di

import com.incetro.projecttemplate.common.di.activity.ActivityComponent
import com.incetro.projecttemplate.common.di.componentmanager.ComponentManager
import com.incetro.projecttemplate.common.di.componentmanager.ComponentsManager
import com.incetro.projecttemplate.common.di.scope.FeatureScope
import com.incetro.projecttemplate.presentation.userstory.tabs.demoscreen.DemoFragment
import com.incetro.projecttemplate.presentation.userstory.tabs.flows.FlowFragmentImpl
import com.incetro.projecttemplate.presentation.userstory.tabs.flows.Tab1FlowFragment
import com.incetro.projecttemplate.presentation.userstory.tabs.flows.Tab2FlowFragment
import com.incetro.projecttemplate.presentation.userstory.tabs.flows.Tab3FlowFragment
import com.incetro.projecttemplate.presentation.userstory.tabs.flows.Tab4FlowFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [
        DemoModule::class
    ]
)
interface DemoComponent {
    fun inject(demoFragment: DemoFragment)
    fun inject(tab1FlowFragment: Tab1FlowFragment)
    fun inject(tab2FlowFragment: Tab2FlowFragment)
    fun inject(tab3FlowFragment: Tab3FlowFragment)
    fun inject(tab4FlowFragment: Tab4FlowFragment)
    fun inject(flowFragmentImpl: FlowFragmentImpl)

    @Component.Builder
    interface Builder {
        fun activityComponent(component: ActivityComponent): Builder
        fun build(): DemoComponent
    }

    object Manager : ComponentManager<DemoComponent>(
        clazz = DemoComponent::class.java,
        createAndSave = {
            val componentManager = ComponentsManager.getInstance()
            val activityComponent = ActivityComponent.Manager.getComponent()
            val component = DaggerDemoComponent.builder()
                .activityComponent(activityComponent)
                .build()
            componentManager.addComponent(component)
        })
}