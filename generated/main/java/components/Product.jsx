

import React from 'react';
import SkyLight from 'react-skylight';
import Alert from 'react-s-alert';
var fetch = require('node-fetch');
import {Link, NavLink, Switch, Redirect} from 'react-router-dom';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';


import Form from "react-jsonschema-form";
import {BaseComponent, BaseEditComponent} from '../commons/BaseComponent.jsx'
import Griddle, {plugins} from 'griddle-react';

import { Layout } from '../commons/Layout.jsx'
import { SimpleView } from '../commons/SimpleView.jsx'
import {Tabs, Tab} from 'material-ui/Tabs';
import {SimpleList} from '../commons/SimpleList.jsx'


export function createSchema(){ 
 
 return {
    title: "Product",
    type: "object",
    required: [ 
],
    properties: {
    

name:{ type: "string", title: "Name",  	
},


    
    }
 };

}

export const productUISchema = {
 	

name: {  'ui:placeholder': "Name" },


    
 }


	export const productHeaders = [
	 
	 
	 {property:"name",title:"Name" }
	      
	 ]




let productSchema = createSchema()
const log = (type) => console.log.bind(console, type);


export class ProductList extends BaseComponent {

    constructor(props) {
        super(props);
        this.entityName = 'products'
        this.name = 'products'
        this.baseLink = "/entities/products/"
        this.editLink = this.baseLink + "edit/"
    }
    
     getEntityName() { return  'products' }

    renderExtra(record) {
        return null
    }


    handleRowSelection(selectedRows) {
        this.props.push(<Link className="btn btn-default btn-xs" to={this.toLink}>Edit</Link>)
        console.log('selectedRows: ' + selectedRows);
    }


    render() {
        let records = this.props.nested ? this.props.records : this.state.records

        if (!records)
            return (<p>Loading...</p>)

        return (
            <div>
                <SimpleList headers={productHeaders} editLink={this.editLink}
                            renderExtra={this.renderExtra}
                            baseLink = {this.baseLink}
                            records={ records } nested={this.props.nested}
                            container={this.props.container} uneditable={this.props.uneditable}
                            containerId={this.props.containerId}
                            prev={this.props.prev}
                />
            </div>
        );
    }
}

export class EditProduct extends BaseEditComponent {

    componentDidMount() {
        if (this.props.match.params.id)
            this.fetchSingleRecord(this.props.match.params.id);
    }

    constructor(props) {
        super(props);
        this.state = {entity: {}};
        this.entityName = 'products'
        this.onSubmit = this.onSubmit.bind(this);
        
        //this.handleChange = this.handleChange.bind(this);
    }

    onSubmit(formData) {
        this.editRecord(formData)
        this.props.history.push('/entities/products')
    }

    render() {
        return (
            <div>
                <h3> Edit Product </h3>
                <Form schema={productSchema}
                	uiSchema={productUISchema}
                      formData={this.state.entity }
                    //onChange={log("changed")}
                      onSubmit={({formData}) => this.onSubmit(formData) }
                      onError={log("errors")}/>
            </div>
        )
    }
}


export class ViewProduct extends BaseEditComponent {

  renderExtra(record) { <p> IN render </p> }
  
  constructor(props) {
    super(props);
    this.state = { record: {}, error: {}, message: {} };
    this.entityName = 'products';
    //this.onSubmit = this.onSubmit.bind(this)
  }
  
  render() {
  
    let record = this.state.entity
     if(!record) return null;
    return (
     <div>
       <SimpleView  headers= {productHeaders} renderExtra={this.renderExtra}
       record={record}   entityName='Product' /> 
       
       <Tabs>
        
         </Tabs>
      </div>
    )	

  }
}



